const greeting = async () => {
    const serverResponse = await fetch('/hello');
    const text = await serverResponse.text;


  const helloContainer = document.getElementById('hello-div');
  dateContainer.innerText = textFromResponse;
}