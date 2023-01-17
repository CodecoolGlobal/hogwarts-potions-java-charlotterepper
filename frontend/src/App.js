import './App.css';
import Rooms from "./components/Rooms";
import Students from "./components/Students";
import Room from "./components/Room";
import {BrowserRouter as Router, Route, Routes} from "react-router-dom";
import CreateRoom from "./components/CreateRoom";

function App() {
    return (
        <Router>
            <div className="App">
                <Routes>
                    <Route path="/rooms" exact element={<Rooms/>}/>
                    <Route path="/students" exact element={<Students/>}/>
                    <Route path="/rooms/:id" exact element={<Room/>}/>
                    <Route path="/rooms/create" exact element={<CreateRoom/>}/>
                </Routes>
            </div>
        </Router>
    );
}

export default App;
