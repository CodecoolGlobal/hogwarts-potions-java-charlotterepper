import {useEffect, useState} from "react";

export default function Potions() {
    const [potions, setPotions] = useState(null);
    const fetchData = () => {
        fetch("http://localhost:8080/potions/")
            .then((response) => response.json())
            .then(data => {
                console.log(data);
                setPotions(data);
            });
    }
    useEffect(() => {
        fetchData();
    }, [])

    return (
        <>
            <div className="container">
                <div className="room">
                    <h2>Brew Potion</h2>
                    <form method="POST" action="http://localhost:8080/potions/" id="potion-form">
                        <label htmlFor="ingredients">Ingredients:</label> <br/><br/>
                        <textarea name="ingredients" rows={4} cols={40}></textarea> <br/><br/>
                        <button type="submit">Brew Potion</button>
                    </form>
                </div>

                {potions && potions.map((potion, index) =>
                    <div className="room" key={index}>
                        <h2>{potion.name}</h2>
                        <p>Student: {potion.student.fullName}</p>
                        <p>Brewing Status: {potion.brewingStatus}</p>
                        <p><strong>Recipe: </strong>{potion.recipe.name}</p>
                        <p><strong>Ingredients:</strong></p>
                        {potion.ingredients && potion.ingredients.map((ingredient, index) =>
                            <ul key={index}>
                                <li>{ingredient.name}</li>
                            </ul>
                        )}
                    </div>
                )}
            </div>
        </>
    );
}