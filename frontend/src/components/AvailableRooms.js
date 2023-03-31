import {useEffect, useState} from "react";
import {Link} from "react-router-dom";

export default function AvailableRooms() {
    const [rooms, setRooms] = useState(null);
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

    return (
        <>
            <div className="container">
                {rooms && rooms.map((room, index) => {
                        if (rooms.length === 0) {
                            return "No available rooms";
                        }
                        return (
                            <div className="room" key={index}>
                                <h2>{room.name}</h2>
                                <p>House: {room.houseType}</p>
                                <p>Capacity: {room.capacity} student(s)</p>
                                <p>This room is
                                    <strong>{room.residents.length === 0 ? " empty" : " occupied"}</strong>
                                </p>
                                <Link to={"/rooms/" + room.id}>Room Details</Link>
                            </div>
                        );
                    }
                )}
            </div>
        </>
    );
}
