import '../styles/App.scss';
import { Routes, Route } from "react-router-dom";
import NavBar from "./NavBar";
import NotFound from "./NotFound";
import Home from '../Home';

function App() {
  return (
    <div className="App">
      <NavBar />
      <Routes>
          <Route path="/" element={<Home />} />
          <Route path="*" element={<NotFound />} />
      </Routes>

    </div>
  );
}

export default App;
