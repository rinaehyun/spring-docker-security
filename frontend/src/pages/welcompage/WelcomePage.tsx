import {Link} from "react-router-dom";

export default function WelcomePage() {

    return (
        <>
            <h3>Welcome to the app !</h3>
            <Link to={"/movie"}>Go to Movie-Page</Link>
        </>
    )
}