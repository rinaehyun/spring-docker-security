import {Movie} from "../../types/Movie.ts";

type MoviePageProps = {
    fetchMovies: () => void,
    movieData: Movie[],
}

export default function MoviePage({fetchMovies, movieData}: MoviePageProps) {

    const handleFetchData = () => {
        fetchMovies();
    }

console.log(movieData);
    return (
        <>
            <h3>Here is the movie page</h3>
            <button onClick={handleFetchData}>Click here to get the Movie data</button>
            {movieData.map(movie =>
                <>
                    <h5 >{movie.title}</h5>
                    <h5>{movie.genre}</h5>
                </>
            )}
        </>
    )
}