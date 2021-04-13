const randomCheckbox = document.getElementById('random');
const randomPasswordGenerator = document.getElementById('randomPasswordGenerator');
const rawPassword = document.getElementById('plainText');
const randomPasswordLength = document.getElementById('randomPasswordLength');
const randomPasswordValue = document.getElementById('randomPasswordValue');
const copyBtnRandomPassword = document.getElementById('randomPasswordcpbtn');
const copyBtnHashedPassword = document.getElementById('randomHashedPasswordcpbtn');

const copyBtns = [copyBtnRandomPassword, copyBtnHashedPassword];

const tooltipTriggerList = [].slice.call(document.querySelectorAll('[data-bs-toggle="tooltip"]'))
const tooltipList = tooltipTriggerList.map(function (tooltipTriggerEl) {
  return new bootstrap.Tooltip(tooltipTriggerEl)
})


randomCheckbox.addEventListener('change', () => {
    document.getElementById('randomPasswordLength').disabled = !randomCheckbox.checked;
    randomPasswordGenerator.disabled = !randomCheckbox.checked;
});

randomPasswordGenerator.addEventListener('click', () => {
	generateRandomPassword(randomPasswordLength.value);
})


const copyValue = (n, id) => {
  const copyText = document.getElementById(id);
  copyText.select();
  copyText.setSelectionRange(0, 99999); 
  document.execCommand("copy");
  copyBtns[n - 1].style.display = 'none';
  setTimeout(() => {
	  copyBtns[n - 1].setAttribute('data-bs-original-title', 'Copied');
	  copyBtns[n - 1].style.display = 'block';
  }, 1);
 
  setTimeout(() => {
	  copyBtns[n - 1].setAttribute('data-bs-original-title', 'Copy to clipboard');
  }, 3000);
}

const generateRandomPassword = len => {
	len = (len === '') ? 10 : len;
	if(len > 256) {
		len = 256;
	}
	const chars = "abcdefghijklmnopqrstuvwxyz!@#$%^&*()-+<>ABCDEFGHIJKLMNOP1234567890";
    let pass = "";
    for (let x = 0; x < len; x++) {
        const pos = Math.floor(Math.random() * chars.length);
        pass += chars.charAt(pos);
    }
    randomPasswordValue.setAttribute("value", pass);
} 