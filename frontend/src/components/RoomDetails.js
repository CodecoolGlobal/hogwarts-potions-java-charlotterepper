import {useEffect, useState} from "react";
import {useNavigate, useParams} from "react-router-dom";

export default function Rooms() {
    const [room, setRoom] = useState(null);
    const allRoomsEndpoint = "http://localhost:8080/rooms/";
    const {id} = useParams();
    const navigate = useNavigate();

    const [data, setData] = useState({name: "", houseType: "GRYFFINDOR", capacity: ""});

    function updateData(updatedData) {
        setData({...data, ...updatedData});
        console.log(data)
    }

    async function updateRoom() {
        try {
            console.log(JSON.stringify(data))
            const result = await fetch("http://localhost:8080/rooms/" + id, {
                method: "PUT",
                headers: {
                    "Content-Type": "application/json"
                },
                body: JSON.stringify(data)
            })
            if (result.status !== 200) {
                alert("An error has occurred: " + result.status);
            }
            return result;
        } catch (error) {
            console.log(error);
        }
    }

    async function handleUpdate(event) {
        event.preventDefault();
        const result = await updateRoom();
        if (result && result.status === 200) {
            alert("Room is updated!")
            window.location.reload();
        }
    }

    async function deleteRoom() {
        try {
            console.log(JSON.stringify(data))
            const result = await fetch("http://localhost:8080/rooms/delete/" + id, {
                method: "DELETE"
            })
            if (result.status !== 200) {
                alert("An error has occurred: " + result.status);
            }
            return result;
        } catch (error) {
            console.log(error);
        }
    }

    async function handleDelete(event) {
        event.preventDefault();
        const result = await deleteRoom();
        if (result && result.status === 200) {
            alert("Room is deleted!")
            navigate("/rooms");
        }
    }

    const fetchRoom = () => {
        fetch(allRoomsEndpoint + id)
            .then((response) => response.json())
            .then(data => {
                console.log(data);
                setRoom(data);
            });
    }
    useEffect(() => {
        fetchRoom();
    }, [])

    if (room == null) {
        return <h1>Loading...</h1>;
    }

    return (
        <>
            <div className="container" id="normal-direction">
                <div className="room">
                    <h2>{room.name}</h2>
                    <p>House: {room.houseType}</p>
                    <p>Capacity: {room.capacity} student(s)</p>
                    <p>This room is
                        <strong>{room.residents.length === 0 ? " empty" : ""}</strong>
                        <strong>{room.residents.length === room.capacity ? " full" : ""}</strong>
                        <strong>{room.residents.length > 0 && room.residents.length < room.capacity ? " occupied" : ""}</strong>
                    </p>
                    {room.residents.length === 0
                        ?  <button onClick={handleDelete}>Delete Room</button>
                        : ""
                    }
                </div>
                <div className="room">
                    <h2>Update Room #{room.id}</h2>
                    <form id="room-form" className="create-room-form">
                        <label htmlFor="room-name">Room Name:</label> <br/>
                        <input onChange={(e) => updateData({name: e.target.value})} type="text" name="room-name" id="room-name" required/> <br/>
                        <label htmlFor="room-house">Hogwarts House:</label> <br/>
                        <select onChange={(e) => updateData({houseType: e.target.value.toUpperCase()})} name="room-house" id="room-house" form="room-form">
                            <option key="gryffindor" value="gryffindor">Gryffindor</option>
                            <option key="hufflepuff" value="hufflepuff">Hufflepuff</option>
                            <option key="ravenclaw" value="ravenclaw">Ravenclaw</option>
                            <option key="slytherin" value="slytherin">Slytherin</option>
                        </select> <br/>
                        <label htmlFor="room-capacity">Room Capacity:</label> <br/>
                        <input onChange={(e) => updateData({capacity: e.target.value})} type="number" min="1" max="1000" name="room-capacity" id="room-capacity"
                               required/>
                        <br/>
                        <button onClick={handleUpdate}>Update Room</button>
                    </form>
                </div>
            </div>
        </>
    );
}
