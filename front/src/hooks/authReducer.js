const authReducer = (auth, action) => {
  switch (action.type) {
    case 'LOGIN':
      return {
        ...auth,
        isLoggedIn: true,
        user: action.user
      };
    case 'SIGNUP':
      return {
        ...auth,
        isSignIn: true,
        user: action.user
      };
      default:
        return auth;
  }
};

export default authReducer;