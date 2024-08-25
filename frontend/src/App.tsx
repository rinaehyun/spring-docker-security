import './App.css'
import WelcomePage from "./pages/welcompage/WelcomePage.tsx";
import MoviePage from "./pages/moviepage/MoviePage.tsx";
import {Route, Routes} from "react-router-dom";
import {useState} from "react";
import {Movie} from "./types/Movie.ts";
import axios from "axios";

function App() {
    const [movieData, setMovieData] = useState<Movie[]>([]);

    const fetchMovies = (): void => {
        axios.get('/api/movie')
            .then(response => {
                setMovieData(response.data);
            })
            .catch(error => {
                console.error("Error fetching data:", error);
            });
    };

    return (
    <>
        <main>
            <Routes>
                <Route path={"/"} element={<WelcomePage />}></Route>
                <Route path={"/movie"} element={<MoviePage fetchMovies={fetchMovies} movieData={movieData}/>}></Route>
            </Routes>
        </main>
    </>
    )
}

export default App
