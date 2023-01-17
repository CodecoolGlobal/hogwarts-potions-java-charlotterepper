import {useEffect, useState} from "react";
import Nav from "./Nav";

export default function Rooms() {
    const [rooms, setRooms] = useState(null);
    const fetchData = () => {
        fetch("http://localhost:8080/rooms/")
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
            <Nav title="All Rooms" />
            <div className="container">
                <h1>All rooms</h1>
                <div className="room">
                    {rooms && rooms.map((room, index) =>
                        <div key={index}>
                            <h2>{room.name}</h2>
                            <p>House: {room.houseType}</p>
                            <p>Capacity: {room.capacity} student(s)</p>
                            <p>Students in this room: </p>
                            {room.residents.map((resident) =>
                                <span>{resident.fullName}</span>
                            )}
                            <p>This room is
                                <strong>{room.listSize === 0 ? " empty" : ""}</strong>
                                <strong>{room.listSize === room.capacity ? " full" : ""}</strong>
                                <strong>{room.listSize > 0 && room.listSize < room.capacity ? " occupied" : ""}</strong>
                            </p>
                            <a href={"http://localhost:8080/rooms/" + room.id} id="all-rooms-btn">Room Details</a>
                        </div>
                    )}
                </div>
            </div>
        </>
    );
}