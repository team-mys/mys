import {defineConfig} from 'vite'
import react from '@vitejs/plugin-react'
import tailwindcss from '@tailwindcss/vite';

export default defineConfig({
    plugins: [
      tailwindcss(),
      react()
    ],
    server: {
      proxy: {
        '/api': {
          // 요청 전달 대상 서버 주소 설정
          target: 'http://59.24.237.51:8080',
          changeOrigin: true,
          secure: false,
        }
      }
    }
  }
);