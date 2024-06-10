function hashPassword() {
    var passwordObject = document.getElementById("password");
    var hashObject = new jsSHA("SHA-512", "TEXT", {numRounds: 5000});
    hashObject.update(password.value);
    var hash = hashObject.getHash("HEX");
    passwordObject.value = hash;
}
