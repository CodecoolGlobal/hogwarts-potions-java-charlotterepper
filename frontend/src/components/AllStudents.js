import {useEffect, useState} from "react";

export default function Rooms() {
    const [students, setStudents] = useState(null);
    const [rooms, setRooms] = useState(null);
    const [roomId, setRoomId] = useState(-1);

    const fetchAllStudents = () => {
        fetch("http://localhost:8080/students")
            .then((response) => response.json())
            .then(data => {
                setStudents(data);
            });
    }

    const fetchAvailableRooms = () => {
        fetch("http://localhost:8080/rooms/available")
            .then((response) => response.json())
            .then(data => {
                setRooms(data);
            });
    }

    useEffect(() => {
        fetchAllStudents();
        fetchAvailableRooms();
    }, [])

    const onChangeSelect = (event) => {
        setRoomId(event.target.value);
    }

    async function addRoom(studentId, roomId) {
        try {
            const result = await fetch("http://localhost:8080/students/" + studentId + "/" + roomId, {
                method: "POST"
            })
            if (result.status !== 200) {
                alert("An error has occurred: " + result.status);
            }
            return result;
        } catch (error) {
            console.log(error);
        }
    }

    async function handleAddRoom(event, studentId) {
        console.log("StudentId: " + studentId);
        console.log("RoomId: " + roomId);
        event.preventDefault();
        const result = await addRoom(studentId, roomId);
        if (result && result.status === 200) {
            alert("Room is added to student!");
            window.location.reload();
        }
    }

    return (
        <>
            <div className="container">
                {students && students.map((student, index) =>
                    <div className="room" key={index}>
                        <h2>{student.firstName + " " + student.lastName}</h2>
                        <p>House: {student.houseType}</p>
                        <p>Pet: {student.petType}</p>
                        <p>Room: {student.room?.name}</p>
                        <form id="room-form" className="create-room-form">
                            <label htmlFor="chosen-room">Add Room:</label> <br/>
                            <select onChange={onChangeSelect} name="chosen-room" id="chosen-room" form="room-form">
                                <option key="empty" value={-1}>---</option>
                                {rooms && rooms.map((room, index) =>
                                    <option value={room.id} key={index}>{room.name}</option>
                                )}
                            </select> <br/>
                            <button onClick={(event) => handleAddRoom(event, student.id)}>Select Room</button>
                        </form>
                    </div>
                )}
            </div>
        </>
    );
}
