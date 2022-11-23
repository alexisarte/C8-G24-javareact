import { useState } from "react"
import { ArrowLeft } from "./slideBar/ArrowLeft"
import { ArrowRight } from "./slideBar/ArrowRight"

export const Slide = ({ slides = [] }) => {

    const [index, setIndex] = useState(0)

    const handleClickNext = (value) => {
        if (value == 'left') {
            setIndex(index + 1)
            if (index == 1) return setIndex(0)
        }
        if (value == 'right') {
            setIndex(index - 1)
            if (index == 0) return setIndex(1)
        }
    }

    return (
        <div className="flex relative" style={{ backgroundColor: `${slides[index].bg}` }}>
            <div onClick={() => handleClickNext('left')} className='flex justify-center flex-col'>
                <ArrowLeft />
            </div>

            <strong className="flex-1 flex flex-col justify-center items-center h-96 text-9xl">
                {slides[index].descuento}
            </strong>

            <div className="flex-1">
                <div className="flex flex-col justify-between items-center h-96">
                    <span className="text-3xl pt-10">{slides[index].titulo1}</span>
                    <strong className="text-6xl py-8 text-center">{slides[index].titulo2}</strong>
                    <span className="text-3xl pb-10">{slides[index].titulo3}</span>
                </div>
            </div>

            <div className="flex-1">
                <img className="h-full" src={slides[index].url} alt="" />
            </div>

            <div onClick={() => handleClickNext('right')} className='flex flex-col justify-center'>
                <ArrowRight />
            </div>
        </div>
    )
}
