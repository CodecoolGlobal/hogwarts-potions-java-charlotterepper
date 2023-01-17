import Nav from "./Nav";

export default function AddStudent() {

    return (
        <>
            <Nav title="Add New Student"/>
            <div className="container">
                <form method="POST" action="http://localhost:8080/students/add" id="student-form"
                      className="create-room-form">
                    <label htmlFor="student-first-name">First Name:</label> <br/>
                    <input type="text" name="student-first-name" id="student-first-name" required/> <br/>
                    <label htmlFor="student-last-name">Last Name:</label> <br/>
                    <input type="text" name="student-last-name" id="student-last-name" required/> <br/>
                    <label htmlFor="student-house-type">Hogwarts House:</label> <br/>
                    <select name="student-house-type" id="student-house-type" form="student-form">
                        <option value="gryffindor">Gryffindor</option>
                        <option value="hufflepuff">Hufflepuff</option>
                        <option value="ravenclaw">Ravenclaw</option>
                        <option value="slytherin">Slytherin</option>
                    </select> <br/>
                    <label htmlFor="student-pet-type">Pet:</label> <br/>
                    <select name="student-pet-type" id="student-pet-type" form="student-form">
                        <option value="cat">Cat</option>
                        <option value="rat">Rat</option>
                        <option value="owl">Owl</option>
                        <option value="none">None</option>
                    </select> <br/>
                    <button type="submit">Add Student</button>
                </form>
            </div>
        </>
    );
}