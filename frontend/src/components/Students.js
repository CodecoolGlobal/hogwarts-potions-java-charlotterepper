import {useEffect, useState} from "react";

export default function Rooms() {
    const [students, setStudents] = useState(null);
    const [rooms, setRooms] = useState(null);
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
        <div className="container">
            {students && students.map(student =>
                <div className="room">
                    <h2>{student.fullName}</h2>
                    <p>House: {student.houseType}</p>

                    <form id="room-form" className="create-room-form"
                          action={"http://localhost:8080/students/add-room/" + student.id} method="POST">
                        <label htmlFor="chosen-room">Room:</label> <br/>
                        <select name="chosen-room" id="chosen-room" form="room-form">
                            {rooms && rooms.map(room => {
                                if (room.listSize === 0 || room.listSize < room.capacity) {
                                    return (
                                        <option value={room.id}>{room.name}</option>
                                    );
                                } else {
                                    return (
                                        ""
                                    );
                                }
                            })}
                        </select> <br/>
                        <button type="submit">Select Room</button>
                    </form>
                </div>
            )}
        </div>
    );
}