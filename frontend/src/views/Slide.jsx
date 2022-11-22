import { useState } from "react"

export const Slide = ({ slides = [] }) => {

    const [index, setIndex] = useState(0)

    const handleClickNext = () => {
        if (index === 2) return setIndex(0)
        setIndex(index + 1)
    }

    const handleClickBack = () => {
        if (index === 0) return setIndex(2)
        setIndex(index - 1)
    }

    return (
        <div className="flex" style={{ backgroundColor: `${slides[index].bg}` }}>

            <button onClick={handleClickBack}><i className="fa-solid fa-caret-left pl-3 animate-pulse"></i></button>

            <span className="flex-1 flex flex-col justify-center items-center h-96 text-9xl">
                {slides[index].descuento}
            </span>

            <div className="flex-1">
                <div className="flex flex-col justify-between items-center h-96">
                    <span className="text-3xl pt-10">{slides[index].titulo1}</span>
                    <p className="text-6xl py-8 text-center">{slides[index].titulo2}</p>
                    <span className="text-3xl pb-10">{slides[index].titulo3}</span>
                </div>
            </div>

            <div className="flex-1">
                <img className="h-full" src={slides[index].url} alt="" />
            </div>

            <button onClick={handleClickNext}><i className="fa-solid fa-caret-right pr-3 animate-pulse"></i></button>

        </div>
    )
}
