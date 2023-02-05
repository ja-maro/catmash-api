const CatListItem = ({ cat }) => {
    return (
        <li>
            <div className="cat">
                    <img src={cat.picture} alt={cat.jsonId}></img>
            </div>
        </li>
    );
};

export default CatListItem;
