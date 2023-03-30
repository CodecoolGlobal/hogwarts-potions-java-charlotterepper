import {useEffect, useState} from "react";
import {useParams} from "react-router-dom";

export default function Rooms() {
    const [room, setRoom] = useState(null);
    const allRoomsEndpoint = "http://localhost:8080/rooms/";
    const {id} = useParams();

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

    async function handleSubmit(event) {
        event.preventDefault();
        const result = await updateRoom();
        if (result && result.status === 200) {
            alert("Room is updated!")
            window.location.reload();
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

    const roomId = room.id;

    return (
        <>
            <div className="container" id="normal-direction">
                <div className="room">
                    <h2>{room.name}</h2>
                    <p>House: {room.houseType}</p>
                    <p>Capacity: {room.capacity} student(s)</p>
                    <p>This room is
                        <strong>{room.listSize === 0 ? " empty" : ""}</strong>
                        <strong>{room.listSize === room.capacity ? " full" : ""}</strong>
                        <strong>{room.listSize > 0 && room.listSize < room.capacity ? " occupied" : ""}</strong>
                    </p>

                    <form method="POST" action={allRoomsEndpoint + "delete/" + roomId}>
                        <button type="submit">Delete Room</button>
                    </form>
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
                        <button onClick={handleSubmit}>Update Room</button>
                    </form>
                </div>
            </div>
        </>
    );
}
