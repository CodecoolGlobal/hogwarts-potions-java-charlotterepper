import './App.css';
import Rooms from "./components/Rooms";
import Students from "./components/Students";
import Room from "./components/Room";
import {BrowserRouter as Router, Route, Routes} from "react-router-dom";
import CreateRoom from "./components/CreateRoom";
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
                    <Route path="/" exact element={<Rooms/>}/>
                    <Route path="/rooms" exact element={<Rooms/>}/>
                    <Route path="/students" exact element={<Students/>}/>
                    <Route path="/rooms/:id" exact element={<Room/>}/>
                    <Route path="/rooms/create" exact element={<CreateRoom/>}/>
                    <Route path="/students/add" exact element={<AddStudent/>}/>
                    <Route path="/rooms/available" exact element={<AvailableRooms/>}/>
                    <Route path="/potions" exact element={<Potions/>}/>
                </Routes>
            </div>
        </Router>
    );
}

export default App;
