export default function Rooms(props) {

    const roomLink = <a href="http://localhost:3000/rooms" id="nav-link">All rooms</a>;
    const availableRoomsLink = <a href="http://localhost:3000/rooms/available" id="nav-link">Available Rooms</a>;
    const createRoomLink = <a href="http://localhost:3000/rooms/create" id="nav-link">Create Room</a>;
    const studentLink = <a href="http://localhost:3000/students" id="nav-link">All Students</a>;
    const addStudentLink = <a href="http://localhost:3000/students/add" id="nav-link">Add Student</a>;

    function showAccordingLinks(name) {
        if (name === "All Students") {
            return <>{roomLink} {addStudentLink}</>;
        }
        if (name === "All Rooms") {
            return <>{studentLink} {createRoomLink} {availableRoomsLink}</>;
        }
        return <>{roomLink}{studentLink}</>;
    }

    return (
        <>
            <nav>
                <h1>{props.title}</h1>
                {showAccordingLinks(props.title)}
            </nav>
        </>
    );
}