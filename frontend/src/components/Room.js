import {useEffect, useState} from "react";
import {useParams} from "react-router-dom";

export default function Rooms() {
    const [room, setRoom] = useState(null);
    const allRoomsEndpoint = "http://localhost:8080/rooms/";
    const {id} = useParams();

    const fetchData = () => {
        fetch(allRoomsEndpoint + id)
            .then((response) => response.json())
            .then(data => {
                console.log(data);
                setRoom(data);
            });
    }
    useEffect(() => {
        fetchData();
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
                    <form method="POST" id="room-form" className="create-room-form" action={allRoomsEndpoint + room.id}>
                        <label htmlFor="room-name">Room Name:</label> <br/>
                        <input type="text" name="room-name" id="room-name" required/> <br/>
                        <label htmlFor="room-house">Hogwarts House:</label> <br/>
                        <select name="room-house" id="room-house" form="room-form">
                            <option value="gryffindor">Gryffindor</option>
                            <option value="hufflepuff">Hufflepuff</option>
                            <option value="ravenclaw">Ravenclaw</option>
                            <option value="slytherin">Slytherin</option>
                        </select> <br/>
                        <label htmlFor="room-capacity">Room Capacity:</label> <br/>
                        <input type="number" min="1" max="1000" name="room-capacity" id="room-capacity"
                               required/>
                        <br/>
                        <button type="submit">Update Room</button>
                    </form>
                </div>
            </div>
        </>
    );
}
