import { useState } from "react";
import Register from "../Register";
import Start from "../Start";

function Login_Register() {
    const [status, setStatus] = useState(true);
    return(
        <div>
            {
                status? <Start setStatus={setStatus}/>: <Register setStatus={setStatus}/>
            }
        </div>
    )
}
export default Login_Register;