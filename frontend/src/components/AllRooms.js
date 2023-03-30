import {useEffect, useState} from "react";
import {Link} from "react-router-dom";

export default function AllRooms() {
    const [rooms, setRooms] = useState(null);
    const fetchData = () => {
        fetch("http://localhost:8080/rooms")
            .then((response) => response.json())
            .then(data => {
                setRooms(data);
            });
    }
    useEffect(() => {
        fetchData();
    }, [])

    return (
        <>
            <div className="container">
                {rooms && rooms.map((room, roomIndex) =>
                    <div className="room" key={roomIndex}>
                        <h2>{room.name}</h2>
                        <p>House: {room.houseType}</p>
                        <p>Capacity: {room.capacity} student(s)</p>
                        <p>This room is
                            <strong>{room.residents.length === 0 ? " empty" : ""}</strong>
                            <strong>{room.residents.length === room.capacity ? " full" : ""}</strong>
                            <strong>{room.residents.length > 0 && room.residents.length < room.capacity ? " occupied" : ""}</strong>
                        </p>
                        <Link to={"/rooms/" + room.id}>Room Details</Link>
                    </div>
                )}
            </div>
        </>
    );
}
