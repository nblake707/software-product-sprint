
const greeting = async () => {
    const serverResponse = await fetch('/hello');
    console.log(serverResponse);
    const jsonList = await serverResponse.json();

     console.log(jsonList);
    

    const helloContainer = document.getElementById('hello-div');
    helloContainer.innerText = jsonList[0];
} 





