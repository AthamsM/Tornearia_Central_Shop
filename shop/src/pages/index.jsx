import Home from "./Home"
import ProductPage from "./ProductPage";
import Register from "./Register";
import Start from "./Start";

const Pages = [
    {
        path : "/inicio",
        component : <Start/>
    },
    {
        path : "/cadastrar",
        component : <Register/>
    },
    {
        path : "/home",
        component : <Home/>
    },
    {
        path : "/produto/:id",
        component : <ProductPage/>
    }
]
export default Pages;
