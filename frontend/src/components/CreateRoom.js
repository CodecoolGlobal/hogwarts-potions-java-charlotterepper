export default function CreateRoom() {

    return (
        <>
            <div className="container">
                <form method="POST" action="http://localhost:8080/rooms/create" id="room-form"
                      className="create-room-form">
                    <label htmlFor="room-name">Room Name:</label> <br/>
                    <input type="text" name="room-name" id="room-name" required/> <br/>
                    <label htmlFor="room-house">Hogwarts House:</label> <br/>
                    <select name="room-house" id="room-house" form="room-form">
                        <option value="gryffindor">Gryffindor</option>
                        <option value="hufflepuff">Hufflepuff</option>
                        <option value="ravenclaw">Ravenclaw</option>
                        <option value="slytherin">Slytherin</option>
                    </select> <br/>
                    <label htmlFor="room-capacity">Room Capacity:</label> <br/>
                    <input type="number" min="1" max="1000" name="room-capacity" id="room-capacity" required/> <br/>
                    <button type="submit">Create room</button>
                </form>

            </div>
        </>
    );
}
