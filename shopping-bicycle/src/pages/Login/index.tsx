import React from "react";
import Input from "../../components/Input";
import "./Login.style.scss"

const Login = () => {
    return (
        <>
            <div className="container">
                <div className="row">
                    <div className="col col-lg-3 col-md-3">-</div>
                    <div className="col col-lg-6 col-md-6 login-box">
                        <div className="col col-lg-12 login-key">
                            <i className="fa fa-key" aria-hidden="true" />
                        </div>
                        <div className="col col-lg-12 login-title">
                            Login
                        </div>
                        <div className="col col-lg-12 login-form">
                            <div className="col col-lg-12 login-form">
                                <form>
                                    <Input labelName={"Nhập tài khoản của bạn *:"}
                                        inputType={"text"}
                                        hint={"Tài khoản của bạn"}
                                        width={400}
                                    />
                                    <Input labelName={"Nhập mật khẩu của bạn *:"}
                                        inputType={"password"}
                                        hint={"Mật khẩu của bạn"}
                                        width={400}
                                    />
                                    <div className="col col-lg-12 loginbttm">
                                        <div className="col col-lg-6 login-btm login-text">
                                            {/* Error Message */}
                                        </div>
                                        <div className="col col-lg-6 login-btm login-button">
                                            <button type="submit" className="btn btn-outline-primary">LOGIN</button>
                                        </div>
                                    </div>
                                </form>
                            </div>
                        </div>
                        <div className="col col-lg-3 col-md-3" />
                    </div>
                    <div className="col col-lg-3 col-md-3">{ }</div>
                </div>
            </div>

        </>
    )
};
export default Login;