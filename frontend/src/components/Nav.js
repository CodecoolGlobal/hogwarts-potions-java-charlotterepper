export default function Nav(props) {

    const roomLink = <a href="http://localhost:3000/rooms" id="nav-link">All rooms</a>;
    const availableRoomsLink = <a href="http://localhost:3000/rooms/available" id="nav-link">Available Rooms</a>;
    const createRoomLink = <a href="http://localhost:3000/rooms/create" id="nav-link">Create Room</a>;
    const studentLink = <a href="http://localhost:3000/students" id="nav-link">All Students</a>;
    const addStudentLink = <a href="http://localhost:3000/students/add" id="nav-link">Add Student</a>;

    const links = [roomLink, availableRoomsLink, createRoomLink, studentLink, addStudentLink];

    return (
        <>
            <nav>
                <h1>Hogwarts Potions</h1>
                {links && links.map((link, linkIndex) =>
                    <p>{link}</p>
                )}
            </nav>
        </>
    );
}
