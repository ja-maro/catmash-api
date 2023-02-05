import CatsService from "../../services/cats.service";
import { useEffect, useState } from "react";
import CatListItem from "./CatListItem";


const CatDuel = () => {
    const [catDuo, setCatDuo] = useState([]);

    useEffect(() => {
        CatsService.getContestants().then((response) => {
            if (response.status === 200) {
                console.log(response);
                setCatDuo(response.data);
            } else if (response.status === 401) {
                console.log(response);
            }
        });
    }, []);

    const handleClickVote = (id) => {
        CatsService.vote(id).then((response) => {
            if (response.status === 200) {
                console.log(response);
                window.location.reload(true);
            } else if (response.status === 401) {
                console.log(response);
                window.location.reload(true);
            }
        });
    };

    return (
        <div className="wrapper">
            <ul className="duel">
                {catDuo.map((cat) => (
                    <div key={cat.id} className="duelist">
                        <button onClick={() => handleClickVote(cat.id)}>
                                Vote for me !
                        </button>
                        <CatListItem key={cat.id} cat={cat} />
                    </div>
                ))}
            </ul>
        </div>
    );
};

export default CatDuel;