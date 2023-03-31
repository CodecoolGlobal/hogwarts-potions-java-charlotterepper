import './App.css';
import AllRooms from "./components/AllRooms";
import Students from "./components/AllStudents";
import Room from "./components/RoomDetails";
import {BrowserRouter as Router, Route, Routes} from "react-router-dom";
import AddRoom from "./components/AddRoom";
import AddStudent from "./components/AddStudent";
import AvailableRooms from "./components/AvailableRooms";
import Nav from "./components/Nav";
import Potions from "./components/Potions";

function App() {
    return (
        <Router>
            <div className="App">
                <Nav/>
                <Routes>
                    <Route path="/" exact element={<AllRooms/>}/>
                    <Route path="/rooms" exact element={<AllRooms/>}/>
                    <Route path="/students" exact element={<Students/>}/>
                    <Route path="/rooms/:id" exact element={<Room/>}/>
                    <Route path="/rooms/add" exact element={<AddRoom/>}/>
                    <Route path="/students/add" exact element={<AddStudent/>}/>
                    <Route path="/rooms/available" exact element={<AvailableRooms/>}/>
                    <Route path="/potions" exact element={<Potions/>}/>
                </Routes>
            </div>
        </Router>
    );
}

export default App;
