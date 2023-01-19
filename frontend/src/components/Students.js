import {useEffect, useState} from "react";

export default function Rooms() {
    const [students, setStudents] = useState(null);
    const [rooms, setRooms] = useState(null);
    const [roomId, setRoomId] = useState(-1);
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

    const onChangeSelect = (event) => {
        setRoomId(event.target.value);
    }

    const addRoom = (studentId, roomId) => {
        fetch(addRoomLink + studentId + "/" + roomId)
            .then(response => response.json())
            .then(data => {
                setRoomId(-1);
            })
    }

    return (
        <>
            <div className="container">
                {students && students.map((student, index) =>
                    <div className="room" key={index}>
                        <h2>{student.fullName}</h2>
                        <p>House: {student.houseType}</p>
                        <p>Pet: {student.petType}</p>
                        <p>Room: {student.room?.name}</p>
                        {/*<p>RoomId: {roomId}</p>*/}

                        {/*<form method="POST" action={addRoomLink + student.id + "/" + roomId} id="room-form" className="create-room-form">*/}
                            <label htmlFor="chosen-room">Add Room:</label> <br/>
                            <select onChange={onChangeSelect} name="chosen-room" id="chosen-room" form="room-form">
                                <option>---</option>
                                {rooms && rooms.map((room, index) => {
                                    if (room.listSize === 0 || room.listSize < room.capacity) {
                                        return (<option value={room.id} key={index}>{room.name}</option>);
                                    }
                                    return ("");
                                })}
                            </select> <br/>
                            <button onClick={() => addRoom(student.id, roomId)}>Select Room</button>
                        {/*</form>*/}
                    </div>
                )}
            </div>
        </>
    );
}