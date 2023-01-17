export default function Rooms(props) {

    const roomLink = <a href="http://localhost:3000/" id="nav-link">All rooms</a>;
    const studentLink = <a href="http://localhost:3000/students" id="nav-link">All Students</a>;

    function showAccordingLinks(name) {
        if (name === "All Students") {
            return roomLink;
        }
        if (name === "All Rooms") {
            return studentLink;
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