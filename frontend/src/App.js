import './App.css';
import Rooms from "./components/Rooms";
import Students from "./components/Students";
import {BrowserRouter as Router, Route, Routes} from "react-router-dom";

function App() {
    return (
        <Router>
            <div className="App">
                <Routes>
                    <Route path="/" exact element={<Rooms/>}/>
                    <Route path="/students" exact element={<Students/>}/>
                </Routes>
            </div>
        </Router>
    );
}

export default App;
