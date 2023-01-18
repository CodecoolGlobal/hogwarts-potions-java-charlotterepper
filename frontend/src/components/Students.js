import {useEffect, useState} from "react";
import Nav from "./Nav";

export default function Rooms() {
    const [students, setStudents] = useState(null);
    const [rooms, setRooms] = useState(null);
    const addRoomLink = "http://localhost:8080/students/";

    const fetchStudentData = () => {
        fetch("http://localhost:8080/students/")
            .then((response) => response.json())
            .then(data => {
                setStudents(data);
            });
    }

    const fetchRoomData = () => {
        fetch("http://localhost:8080/rooms/")
            .then((response) => response.json())
            .then(data => {
                setRooms(data);
            });
    }

    useEffect(() => {
        fetchStudentData();
        fetchRoomData();
    }, [])

    return (
        <>
            <Nav title="All Students"/>
            <div className="container">
                {students && students.map((student, index) =>
                    <div className="room" key={index}>
                        <h2>{student.fullName}</h2>
                        <p>House: {student.houseType}</p>
                        <p>Pet: {student.petType}</p>

                        <form method="POST" action={addRoomLink + student.id} id="room-form" className="create-room-form">
                            <label htmlFor="chosen-room">Room:</label> <br/>
                            <select name="chosen-room" id="chosen-room" form="room-form">
                                {rooms && rooms.map((room, index) => {
                                    if (room.listSize === 0 || room.listSize < room.capacity) {
                                        return (<option value={room.id} key={index}>{room.name}</option>);
                                    }
                                    return ("");
                                })}
                            </select> <br/>
                            <button type="submit">Select Room</button>
                        </form>
                    </div>
                )}
            </div>
        </>
    );
}