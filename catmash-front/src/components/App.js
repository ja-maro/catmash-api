import '../styles/App.scss';
import { Routes, Route } from "react-router-dom";
import NavBar from "./NavBar";
import NotFound from "./NotFound";
import CatList from './cats/CatList';
import CatDuel from './cats/CatDuel';

function App() {
  return (
    <div className="App">
      <NavBar />
      <Routes>
          <Route path="/" element={<CatDuel />} />
          <Route path="/cats" element={<CatList />} />
          <Route path="*" element={<NotFound />} />
      </Routes>

    </div>
  );
}

export default App;
