import {createContext, useContext, useState} from 'react';
import axios from 'axios';

const AuthContext = createContext();

export function AuthProvider({children}) {
  const [user, setUser] = useState(null);

  const signup = async (userData) => {
    try {
      const response = await axios.post(
        'http://59.24.237.51:8080/api/v1/user',
        userData,
        {
          headers: {
            'Content-Type': 'application/json',
            'Accept': '*/*'
          }
        }
      );
      setUser(response.data); // 회원가입 성공 시 상태 업데이트
      console.log(response.data);
    } catch (error) {
      console.error("회원가입 실패",error);
    }
  };

  const login = async (userData) => {
    try {
      const response = await axios.post(
        'http://59.24.237.51:8080/api/v1/user/login',
        userData,
        {
          headers: {
            'Content-Type': 'application/json',
            'Accept': '*/*'
          }
        }
      );
      setUser(response.data); // 로그인 성공 시 상태 업데이트
      console.log(response.data);
    } catch (error) {
      console.error("로그인 실패", error);
    }
  };

  const viewUser = async () => {
    try {
      const response = await axios.get(
        'http://59.24.237.51:8080/api/v1/user'
      );
      setUser(response.data); // 유저 정보 업데이트
      console.log('현재 사용자 정보:', response.data);
    } catch (error) {
      console.error('유저 정보 가져오기 실패:', error);
    }
  };

  return (
    <AuthContext.Provider value={{user, signup, viewUser, login}}>
      {children}
    </AuthContext.Provider>
  );
}

export function useAuth() {
  return useContext(AuthContext);
}