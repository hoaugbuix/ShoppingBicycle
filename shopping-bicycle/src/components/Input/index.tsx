import React from "react";
import "./Input.style.scss";

interface Props {
    labelName: string;
    inputType: string;
    hint: string;
    width: number;
    ref?: any;

}

const Input: React.FC<Props> = React.forwardRef((props: Props) => {
    return (
        <>
            <div className="wrapper__input">
                <label htmlFor="fnName">{props.labelName}</label>
                <input type={props.inputType}
                    id="fnName"
                    name="fnName"
                    placeholder={props.hint}
                    className="wrapper__input-style"
                    style={{ width: props.width + 'px' }}
                    ref={props.ref}
                    {...props}
                />
                <span className="input__request"></span>
            </div>
        </>
    )
});

export default Input;