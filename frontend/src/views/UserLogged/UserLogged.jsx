import { Dropdown } from "flowbite-react";
import { Label, TextInput, Checkbox, Button } from "flowbite-react";

const UserLogged = ({registerUser , setRegisterUser}) => {
  return (
    <>
    <Dropdown.Header>
        <span className="block text-sm">Conectarme a mi cuenta</span>
        <span className="block text-sm font-medium truncate">
          Ingresa tu e-mail y tu contraseña
        </span>
      </Dropdown.Header>
      <form className="flex flex-col gap-4 mx-4">
        <div>
         
          <TextInput
            id="email1"
            type="email"
            placeholder="E-Mail"
            required={true}
          />
        </div>
        <div>
         
          <TextInput id="password1" type="password" placeholder="Contraseña" required={true} />
        </div>
        <div className="flex items-center gap-2">
          <Checkbox id="remember" />
          <Label htmlFor="remember">Remember me</Label>
        </div>
        <Button type="submit" color="dark">ENTRAR</Button>
        <span className="block text-sm">¿Nuevo cliente? <button onClick={()=>{setRegisterUser(false)}}>Crear cuenta</button></span>
        <span className="block text-sm font-medium truncate">
          ¿Olvidaste tu contraseña? <span>Recuperar contraseña</span> 
        </span>
      </form> 
    </>
  )
}

export default UserLogged
