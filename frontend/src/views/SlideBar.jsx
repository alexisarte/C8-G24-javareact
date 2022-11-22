import { Slide } from "./Slide"

export const SlideBar = () => {
    const slides = [
        { descuento: '50%', titulo1: 'APROVECHA NUESTRO', titulo2: 'BLACK FRIDAY', titulo3: 'OFERTAS IMPERDIBLES', url: '../src/assets/dogSmile.png', bg: '#F7D3F3' },
        { descuento: '30%', titulo1: 'APROVECHA NUESTRO', titulo2: 'BLACK FRIDAY', titulo3: 'OFERTAS IMPERDIBLES', url: '../src/assets/dogSmile.png', bg: '#90A8FF' },
        { descuento: '40%', titulo1: 'APROVECHA NUESTRO', titulo2: 'BLACK FRIDAY', titulo3: 'OFERTAS IMPERDIBLES', url: '../src/assets/dogSmile.png', bg: '#78A55A' }
    ]

    return (
        <Slide slides={slides} />
    )
}
