export default function Rooms(props) {
    function showAccordingLinks(name) {
        if (name === "All Students") {
            return <a href="http://localhost:3000/" className="nav-link">All rooms</a>;
        }
        if (name === "All Rooms") {
            return <a href="http://localhost:3000/students" className="nav-link">All students</a>;
        }
        return <>
            <a href="http://localhost:3000/" className="nav-link">All rooms</a>
            <a href="http://localhost:3000/students" className="nav-link">All students</a>
        </>;
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