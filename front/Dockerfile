FROM node:18

WORKDIR /app

COPY package.json package-lock.json* ./

RUN npm install && npm rebuild esbuild

COPY . .

EXPOSE 5173

CMD ["npm", "run", "dev"]