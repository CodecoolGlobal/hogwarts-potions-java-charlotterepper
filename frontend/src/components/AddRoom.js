import {useNavigate} from "react-router-dom";
import {useState} from "react";

export default function AddRoom() {
    const [data, setData] = useState({
        id: null,
        name: "",
        houseType: "GRYFFINDOR",
        capacity: "",
        residents: null
    });
    const navigate = useNavigate();

    function updateData(updatedData) {
        setData({...data, ...updatedData});
    }

    async function addRoom() {
        try {
            const result = await fetch("http://localhost:8080/rooms/add", {
                method: "POST",
                headers: {
                    "Content-Type": "application/json"
                },
                body: JSON.stringify(data)
            })
            if (result.status !== 200) {
                alert("An error has occurred: " + result.status);
            }
            return result;
        } catch (error) {
            console.log(error);
        }
    }

    async function handleSubmit(event) {
        event.preventDefault();
        const result = await addRoom();
        if (result && result.status === 200) {
            alert("New room added!")
            navigate("/rooms");
        }
    }

    return (
        <>
            <div className="container">
                <form id="room-form" className="create-room-form">
                    <label htmlFor="room-name">Room Name:</label> <br/>
                    <input onChange={(e) => updateData({name: e.target.value})} type="text"
                           name="room-name" id="room-name" required/> <br/>
                    <label htmlFor="room-house">Hogwarts House:</label> <br/>
                    <select onChange={(e) => updateData({houseType: e.target.value.toUpperCase()})}
                            name="room-house" id="room-house" form="room-form">
                        <option key="gryffindor" value="gryffindor">Gryffindor</option>
                        <option key="hufflepuff" value="hufflepuff">Hufflepuff</option>
                        <option key="ravenclaw" value="ravenclaw">Ravenclaw</option>
                        <option key="slytherin" value="slytherin">Slytherin</option>
                    </select> <br/>
                    <label htmlFor="room-capacity">Room Capacity:</label> <br/>
                    <input onChange={(e) => updateData({capacity: e.target.value})}
                           type="number" min="1" max="1000" name="room-capacity" id="room-capacity" required/> <br/>
                    <button onClick={handleSubmit}>Create room</button>
                </form>
            </div>
        </>
    );
}
