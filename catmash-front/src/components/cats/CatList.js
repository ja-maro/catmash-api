import { useEffect, useState } from "react";
import CatListItem from "./CatListItem";
import CatsService from "../../services/cats.service";

const CatList = () => {
    const [catList, setCatList] = useState([]);

    useEffect(() => {
        CatsService.getAllCats().then((response) => {
            if (response.status === 200) {
                console.log(response);
                setCatList(response.data);
            } else if (response.status === 401) {
                console.log(response);
            }
        });
    }, []);

    return (
        <div className="wrapper">
            <ul>
            <div>
            <h1>All cats by popularity :</h1></div>
                {catList.map((cat) => (
                    <div key={cat.id}>
                        <CatListItem key={cat.id} cat={cat} />
                    </div>
                ))}
            </ul>
        </div>
    );
};

export default CatList;
