import { Slide } from "./Slide"

export const SlideBar = () => {
    const slides = [
        { descuento: '50%', titulo1: 'APROVECHA NUESTRO', titulo2: 'BLACK FRIDAY', titulo3: 'OFERTAS IMPERDIBLES', url: '../src/assets/sonriendo1-ok.png', bg: '#F7D3F3' },
        { descuento: '25%', titulo1: 'ACCESORIOS PARA', titulo2: 'TU MASCOTA', titulo3: 'los mejores..', url: '../src/assets/sonriendo2-ok.png', bg: '#90A8FF' },
        { descuento: '40%', titulo1: 'APROVECHA NUESTRO', titulo2: 'BLACK FRIDAY', titulo3: 'OFERTAS IMPERDIBLES', url: '../src/assets/sonriendo3-ok.png', bg: '#78A55A' }
    ]

    return (
        <Slide slides={slides} />
    )
}
