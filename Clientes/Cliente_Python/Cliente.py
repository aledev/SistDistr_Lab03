import FinanzaLibrary

def ingresarPersona():
    nombrePersona = int(input("Nombre de la persona:"))
    fchMovimiento = int(input("Digite:"))
    saldoMovimiento = int(input("Saldo:"))

def editarPersona():
    id = int(input("Identificador:"))
    nombrePersona = int(input("Nombre de la persona:"))
    fchMovimiento = int(input("Digite:"))
    saldoMovimiento = int(input("Saldo:"))

def eliminarPersona():
    id = int(input("Identificador:"))

def listarPersonas():
    FinanzaLibrary.consumeGet()

def main():
    while True:
        try:
            print("Elija una opcion \n")
            print("1.Listar personas de Finanzas \n")
            print("2.XXX \n")
            print("3.XXX \n")
            print("4.XXX \n")

            opt = int(input("Opcion:"))            
            print(opt)

            if opt == 1:
                listarPersonas()
            else:
                print("Ups.. \n")            
        except:
            print ("\n Ha ocurrido un error, favor intentar nuevamente. Si el problema persiste, llame al administrador")

if __name__=="__main__":main()


