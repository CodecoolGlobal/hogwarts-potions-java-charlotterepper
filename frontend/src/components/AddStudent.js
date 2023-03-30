import {useState} from "react";
import {useNavigate} from "react-router-dom";


export default function AddStudent() {
    const [data, setData] = useState({firstName: "", lastName: "", houseType: "GRYFFINDOR", petType: "CAT"});
    const navigate = useNavigate();

    function updateData(updatedData) {
        setData({...data, ...updatedData});
    }

    async function addStudent() {
        try {
            const result = await fetch("http://localhost:8080/students/add", {
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
        const result = await addStudent();
        if (result && result.status === 200) {
            alert("New student added!")
            navigate("/students");
        }
    }

    return (
        <>
            <div className="container">
                <form id="student-form" className="create-room-form">
                    <label htmlFor="firstName">First Name:</label> <br/>
                    <input onChange={(e) => updateData({firstName: e.target.value})} type="text"
                           name="firstName" id="firstName" required/> <br/>
                    <label htmlFor="lastName">Last Name:</label> <br/>
                    <input onChange={(e) => updateData({lastName: e.target.value})}
                           type="text" name="lastName" id="lastName" required/> <br/>
                    <label htmlFor="houseType">Hogwarts House:</label> <br/>
                    <select onChange={(e) => updateData({houseType: e.target.value.toUpperCase()})}
                            name="houseType" id="houseType" form="student-form">
                        <option key="gryffindor" value="gryffindor">Gryffindor</option>
                        <option key="hufflepuff" value="hufflepuff">Hufflepuff</option>
                        <option key="ravenclaw" value="ravenclaw">Ravenclaw</option>
                        <option key="slytherin" value="slytherin">Slytherin</option>
                    </select> <br/>
                    <label htmlFor="petType">Pet:</label> <br/>
                    <select onChange={(e) => updateData({petType: e.target.value.toUpperCase()})}
                            name="petType" id="petType" form="student-form">
                        <option key="cat" value="cat">Cat</option>
                        <option key="rat" value="rat">Rat</option>
                        <option key="owl" value="owl">Owl</option>
                        <option key="none" value="none">None</option>
                    </select> <br/>
                    <button onClick={handleSubmit}>Add Student</button>
                </form>
            </div>
        </>
    );
}
