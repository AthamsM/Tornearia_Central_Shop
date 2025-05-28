import Home from "./Home"
import Register from "./Register";
import Start from "./Start";

const Pages = [
    {
        path : "/",
        component : <Start/>
    },
    {
        path : "/cadastrar",
        component : <Register/>
    },
    {
        path : "/home",
        component : <Home/>
    }
]
export default Pages;