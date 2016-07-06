#!/usr/bin/php
<?php

// referencia http://phphttpclient.com/

include('httpful.phar');

echo "********* cliente rest--CRUD-mongoDB ************". "\n";
echo "1.-LEER ". "\n";
echo "2.-CREAR". "\n";
echo "3.-ACTUALIZAR". "\n";
echo "4.-BORRAR". "\n";

echo "Seleccione accion:";

$accion =trim(fgets(STDIN)); // reads one line from STDIN
$token=true;

while($token)
{
  switch ($accion)
 {
    case 1:
        get();
        echo "Ingrese valor a crear". "\n";
        $token=false;
        break;
    case 2:
        post();
        echo "Ingrese valor a  ". "\n";
	$token=false;
        break;
    case 3:
        put();
        $token=false;        
	break;
    case 4:
        delete();
        $token=false;        
        break;
        
    default:

	echo "****** La opcion ingresada no es valida ******". "\n";       
	echo "Seleccione accion:". "\n";
	$accion =trim(fgets(STDIN)); // reads one line from STDIN
        break;
 }
}

function get()
{

    echo "get. id a recuperar.\n";
    $get =trim(fgets(STDIN)); // reads one line from STDIN
    $url = "http://192.168.43.189:8080/finanza/lista";
    $response = \Httpful\Request::get($url)
    ->body($get)
    ->expectsJson()
    ->withXTrivialHeader('demo de un eventos get')
    ->send();
    var_dump($response->body);
//echo "{$response->body->name} joined GitHub on " .date('M jS', strtotime($response->body->created_at)) ."\n";

//return $valor_devuelto;
}


function post()
{

echo "post. ingrese  dato a insertar.\n";
$post =trim(fgets(STDIN)); // reads one line from STDIN
    $url = "http://192.168.43.189:8080/finanza/crear";
$response = \Httpful\Request::post($url)
    
    ->body($post)
    ->expectsJson()
    ->withXTrivialHeader('demo de un eventos post')
    ->send();

    var_dump($response->body);
}

function put()
{
    echo "put. ingrese  dato a editar.\n";
    $put =trim(fgets(STDIN)); // reads one line from STDIN
    
    $url = "http://192.168.43.189:8080/finanza/editar";
    $response = \Httpful\Request::put($url)                  // Build a PUT request...
    
    ->body($put)
    //->expectsJson()
    //->withXTrivialHeader('demo de un eventos put')
    ->send();     

echo "{$response->body->name}  " .date('M jS', strtotime($response->body->created_at)) ."\n";
}


function delete()
{

echo "delete. ingrese  dato a editar.\n";
$delete =trim(fgets(STDIN)); // reads one line from STDIN
//Send off a DELETE request. Authenticate with a client side certificate.  
    $url = "http://192.168.43.189:8080/finanza/eliminar";
    $response = \Httpful\Request::put($url)                  // Build a PUT request...
    
    ->body($delete)
    //->expectsJson()
    //->withXTrivialHeader('demo de un eventos put')
    ->send();

echo "{$response->body->name}  " .date('M jS', strtotime($response->body->created_at)) ."\n";
}

?>
