import {useEffect, useState} from "react";

export default function AvailableRooms() {
    const [rooms, setRooms] = useState(null);
    const roomLink = "http://localhost:3000/rooms/";
    const fetchData = () => {
        fetch("http://localhost:8080/rooms/available")
            .then((response) => response.json())
            .then(data => {
                setRooms(data);
            });
    }
    useEffect(() => {
        fetchData();
    }, [])

    function showAvailableRooms(room) {
        if (room.listSize === 0 || room.listSize < room.capacity) {
            return <>
                <h2>{room.name}</h2>
                <p>House: {room.houseType}</p>
                <p>Capacity: {room.capacity} student(s)</p>
                <p>This room is
                    <strong>{room.listSize === 0 ? " empty" : ""}</strong>
                    <strong>{room.listSize === room.capacity ? " full" : ""}</strong>
                    <strong>{room.listSize > 0 && room.listSize < room.capacity ? " occupied" : ""}</strong>
                </p>
            </>;
        }
        return "No available rooms";
    }

    return (
        <>
            <div className="container">
                {rooms && rooms.map((room, index) =>
                    <div className="room" key={index}>
                        {showAvailableRooms(room)}
                        <a href={roomLink + room.id} id="all-rooms-btn">Room Details</a>
                    </div>
                )}
            </div>

        </>
    );
}