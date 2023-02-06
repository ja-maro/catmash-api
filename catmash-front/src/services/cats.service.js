import axios from "axios";

const API_URL = "http://localhost:8090/";
// const API_URL = process.env.REACT_APP_CATMASH_API_URL;

const getContestants = async (id) => {
    let response;
    await axios
        .get(API_URL + "cats", {})
        .then((result) => {
            console.log("-API_URL : " + API_URL);
            response = result;
        })
        .catch((error) => {
            response = error.toJSON();
        });
    return response;
};

const getAllCats = async () => {
    let response;
    await axios
        .get(API_URL + "cats/all", {})
        .then((result) => {
            response = result;
        })
        .catch((error) => {
            response = error.toJSON();
        });
    return response;
};

const getTop5Cats = async () => {
    let response;
    await axios
        .get(API_URL + "cats/top", {})
        .then((result) => {
            response = result;
        })
        .catch((error) => {
            response = error.toJSON();
        });
    return response;
};

const vote = async (
    id
) => {
    let response;
    await axios
        .put(
            API_URL + "cats/" + id, {})
        .then((result) => {
            response = result;
        })
        .catch((error) => {
            response = error.toJSON();
        });
    return response;
};


const CatsService = { getAllCats, getContestants, getTop5Cats, vote };

export default CatsService;
