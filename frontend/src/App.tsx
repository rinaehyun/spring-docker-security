import './App.css'
import WelcomePage from "./pages/welcompage/WelcomePage.tsx";
import MoviePage from "./pages/moviepage/MoviePage.tsx";
import {Route, Routes} from "react-router-dom";

function App() {

    return (
    <>
        <main>
            <Routes>
                <Route path={"/"} element={<WelcomePage />}></Route>
                <Route path={"/movie"} element={<MoviePage />}></Route>
            </Routes>
        </main>
    </>
    )
}

export default App
